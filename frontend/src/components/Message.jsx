import ReactMarkdown from "react-markdown";

function Message({ message }) {

    const isUser = message.sender === "USER";

    return (

		<div
		    style={{
		        display: "flex",
		        justifyContent: isUser ? "flex-end" : "flex-start",
		        marginBottom: "20px",
		        width: "100%"
		    }}
		>

            <div
			style={{
			    background: isUser ? "#2563eb" : "#374151",
			    color: "white",
			    padding: "16px",
			    borderRadius: "16px",

			    maxWidth: isUser ? "40%" : "750px",

			    width: "fit-content",

			    lineHeight: "1.6",
			    fontSize: "15px",

			    whiteSpace: "pre-wrap",
			    wordBreak: "break-word"
			}}
            >

                <ReactMarkdown>
                    {message.content}
                </ReactMarkdown>

            </div>

        </div>

    );

}

export default Message;