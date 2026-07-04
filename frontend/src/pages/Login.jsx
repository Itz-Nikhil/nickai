import { useState } from "react";
import { useNavigate, Link } from "react-router-dom";
import { login } from "../services/authService";
import toast from "react-hot-toast";

function Login() {

    const navigate = useNavigate();

    const [form, setForm] = useState({
        email: "",
        password: ""
    });

    const handleChange = (e) => {

        setForm({
            ...form,
            [e.target.name]: e.target.value
        });

    };

    const handleSubmit = async (e) => {

        e.preventDefault();

        try {

            const response = await login(form);

            localStorage.setItem("token", response.data.token);

            toast.success("Login Successful");

            navigate("/chat");

        } catch (error) {

            toast.error(
                error.response?.data?.error || "Login Failed"
            );

        }

    };

    return (
        <div className="login-container">

            <h1>NickAI</h1>

            <form onSubmit={handleSubmit}>

                <input
                    type="email"
                    name="email"
                    placeholder="Email"
                    value={form.email}
                    onChange={handleChange}
                    required
                />

                <input
                    type="password"
                    name="password"
                    placeholder="Password"
                    value={form.password}
                    onChange={handleChange}
                    required
                />

                <button type="submit">
                    Login
                </button>

            </form>

            <p>
                Don't have an account?

                <Link to="/register">
                    Register
                </Link>

            </p>

        </div>
    );

}

export default Login;