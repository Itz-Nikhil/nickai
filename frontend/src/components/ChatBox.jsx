function ChatBox() {

    return (

        <div className="chat-box">

            <div className="messages">

                <h1>Welcome to NickAI 👋</h1>

            </div>

            <div className="input-area">

                <input
                    type="text"
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