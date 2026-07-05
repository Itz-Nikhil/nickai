import { useState } from "react";
import Sidebar from "../components/Sidebar";
import ChatBox from "../components/ChatBox";

function Chat() {

    const [selectedConversation, setSelectedConversation] = useState(null);

    return (
        <div className="chat-layout">

            <Sidebar
                selectedConversation={selectedConversation}
                setSelectedConversation={setSelectedConversation}
            />

            <ChatBox
                selectedConversation={selectedConversation}
            />

        </div>
    );
}

export default Chat;