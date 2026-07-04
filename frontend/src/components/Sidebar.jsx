import { useEffect, useState } from "react";
import { getConversations } from "../services/chatService";

function Sidebar() {

    const [conversations, setConversations] = useState([]);

    useEffect(() => {

        loadConversations();

    }, []);

    async function loadConversations() {

        try {

			const response = await getConversations();

			console.log("API Response:", response.data);

			setConversations(response.data);

        } catch (error) {

            console.error(error);

        }

    }

    return (

        <div className="sidebar">

            <h2>NickAI</h2>

            <button>+ New Chat</button>

			<h3>Total: {conversations.length}</h3>

			{
			    conversations.map((conversation) => (

			        <div
			            key={conversation.id}
			            className="conversation"
			        >
			            {conversation.title}
			        </div>

			    ))
			}

        </div>

    );

}

export default Sidebar;