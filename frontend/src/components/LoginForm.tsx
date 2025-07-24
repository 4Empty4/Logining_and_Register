import * as React from 'react';
import './styles/login.scss';
import {useState} from "react";
import 'es6-promise';

interface LoginData {
    login: string;
    password: string;
}

interface UserResponse {
    id: number;
    login: string;
    email: string;
}

const LoginForm: React.FC = () => {
    const [loginData, setLoginData] = useState<LoginData>({
        login: '',
        password: '',
    });

    const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        const { name, value } = e.target;
        setLoginData(prev => ({
            ...prev,
            [name]: value
        }));
    };

    const handleSubmit = async (e: React.FormEvent) => {
        try {
            const response = await fetch('http://localhost:8080/api/auth/login', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(loginData),
            });

            if (response.ok) {
                const user: UserResponse = await response.json();
                alert(`Вітаємо, ${user.login}! Вхід успішний. Ваш email: ${user.email}`);
            } else {
                alert('Невірний логін або пароль');
            }
        } catch (error) {
            console.error('Помилка входу:', error);
            alert('Сталася помилка при вході');
        }
    };
    return (
        <div className="login-container">
            <h2>Вхід</h2>
            <form onSubmit={handleSubmit}>
                <div className="form-group">
                    <label>Логін:</label>
                    <input
                        type="text"
                        name="login"
                        value={loginData.login}
                        onChange={handleChange}
                        required
                    />
                </div>
                <div className="form-group">
                    <label>Пароль:</label>
                    <input
                        type="password"
                        name="password"
                        value={loginData.password}
                        onChange={handleChange}
                        required
                    />
                </div>
                <button type="submit" className="submit-btn">Увійти</button>
            </form>
        </div>
    );
};

export default LoginForm;