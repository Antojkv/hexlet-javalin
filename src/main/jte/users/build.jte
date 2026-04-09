@template.layout.page(
    title = "Регистрация пользователя",
    content = @`
        <h1>Регистрация нового пользователя</h1>

        <form action="/users" method="post">
            <div style="margin-bottom: 15px;">
                <label>
                    Имя:
                    <br/>
                    <input type="text" name="name" required style="width: 100%; padding: 8px; margin-top: 5px;" />
                </label>
            </div>

            <div style="margin-bottom: 15px;">
                <label>
                    Email:
                    <br/>
                    <input type="email" name="email" required style="width: 100%; padding: 8px; margin-top: 5px;" />
                </label>
            </div>

            <div style="margin-bottom: 15px;">
                <label>
                    Пароль:
                    <br/>
                    <input type="password" name="password" required style="width: 100%; padding: 8px; margin-top: 5px;" />
                </label>
            </div>

            <div style="margin-bottom: 15px;">
                <label>
                    Подтверждение пароля:
                    <br/>
                    <input type="password" name="passwordConfirmation" required style="width: 100%; padding: 8px; margin-top: 5px;" />
                </label>
            </div>

            <button type="submit" style="background-color: #4CAF50; color: white; padding: 10px 20px; border: none; border-radius: 5px; cursor: pointer;">
                Зарегистрировать
            </button>
            <a href="/users" style="margin-left: 10px;">Отмена</a>
        </form>
    `
)