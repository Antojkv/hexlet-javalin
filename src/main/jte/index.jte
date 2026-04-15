@import org.example.hexlet.NamedRoutes
@import org.example.hexlet.dto.MainPage
@param MainPage page

@template.layout.page(
    page = page,
    content = @`
        <h1>🎓 Добро пожаловать на платформу Хекслет!</h1>

        @if(page.getCurrentUser() != null)
            <div style="background-color: #e8f5e9; border: 1px solid #4CAF50; border-radius: 5px; padding: 15px; margin: 20px 0;">
                <p>✅ <strong>Добро пожаловать, ${page.getCurrentUser()}!</strong> Вы успешно вошли на сайт.</p>
                <form action="/sessions/delete" method="post" style="display: inline;">
                    <button type="submit" style="background-color: #f44336; color: white; padding: 5px 10px; border: none; border-radius: 3px; cursor: pointer;">
                        Выйти
                    </button>
                </form>
            </div>
        @else
            @if(!page.isVisited())
                <div style="background-color: #e3f2fd; border: 1px solid #2196F3; border-radius: 5px; padding: 15px; margin: 20px 0;">
                    <p>✨ <strong>Добро пожаловать в первый раз!</strong> Это сообщение показывается только один раз.</p>
                </div>
            @endif

            <div style="margin: 20px 0;">
                <a href="${NamedRoutes.buildSessionPath()}" style="background-color: #4CAF50; color: white; padding: 10px 20px; text-decoration: none; border-radius: 5px;">
                    Войти на сайт
                </a>
            </div>
        @endif

        <p><a href="/courses">Посмотреть все курсы →</a></p>
        <p><a href="/users">Посмотреть пользователей →</a></p>
    `
)
