import { useEffect, useRef, useState } from "react";
import { getMessages } from "../services/chatService";
import Message from "./Message";

function ChatBox({ selectedConversation }) {

    const [messages, setMessages] = useState([]);
	
	const messagesEndRef = useRef(null);
	
	useEffect(() => {

	    messagesEndRef.current?.scrollIntoView({

	        behavior: "smooth"

	    });

	}, [messages]);

    useEffect(() => {

        if (selectedConversation) {
            loadMessages();
        } else {
            setMessages([]);
        }

    }, [selectedConversation]);

    async function loadMessages() {

        try {

            const response = await getMessages(selectedConversation.id);

            setMessages(response.data);

        } catch (error) {

            console.error(error);

        }

    }

    return (

        <div className="chat-box">

            <div className="messages">

			{
			    messages.map(message => (
			        <Message
			            key={message.id}
			            message={message}
			        />
			    ))
			}
			
			<div ref={messagesEndRef}></div>

            </div>

            <div className="input-area">

                <input
                    placeholder="Ask anything..."
                />

                <button>
                    Send
                </button>

            </div>

        </div>

    );

}

export default ChatBox;