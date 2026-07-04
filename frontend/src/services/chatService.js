import api from "../api/api";

export const sendMessage = (data) => {
    return api.post("/chat", data);
};

export const getConversations = () => {
    return api.get("/conversations");
};

export const getMessages = (conversationId) => {
    return api.get(`/messages/${conversationId}`);
};

export const deleteConversation = (conversationId) => {
    return api.delete(`/conversations/${conversationId}`);
};