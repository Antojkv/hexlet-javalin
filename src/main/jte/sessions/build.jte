@import org.example.hexlet.NamedRoutes
@param BuildUserPage page = null

@template.layout.page(
    page = page,
    content = @`
        <h1>Вход на сайт</h1>

        <form action="${NamedRoutes.sessionsPath()}" method="post">
            <div style="margin-bottom: 15px;">
                <label>
                    Имя пользователя:
                    <br/>
                    <input type="text" name="nickname" required style="width: 100%; padding: 8px; margin-top: 5px;" />
                </label>
            </div>

            <div style="margin-bottom: 15px;">
                <label>
                    Пароль:
                    <br/>
                    <input type="password" name="password" style="width: 100%; padding: 8px; margin-top: 5px;" />
                </label>
            </div>

            <button type="submit" style="background-color: #4CAF50; color: white; padding: 10px 20px; border: none; border-radius: 5px; cursor: pointer;">Войти</button>
            <a href="/" style="margin-left: 10px;">Отмена</a>
        </form>
    `
)