@import org.example.hexlet.dto.MainPage
@param MainPage page

@template.layout.page(
    title = "Главная",
    content = @`
        <h1>🎓 Добро пожаловать на платформу Хекслет!</h1>
        <p>Изучайте программирование с лучшими курсами. Начните свой путь в IT уже сегодня!</p>

        @if(!page.isVisited())
            <div style="background-color: #e8f5e9; border: 1px solid #4CAF50; border-radius: 5px; padding: 15px; margin: 20px 0;">
                <p>✨ <strong>Добро пожаловать в первый раз!</strong> Это сообщение показывается только один раз.</p>
                <p>Если вы хотите увидеть его снова, очистите cookies в браузере.</p>
            </div>
        @endif

        <p><a href="/courses">Посмотреть все курсы →</a></p>
        <p><a href="/users">Посмотреть пользователей →</a></p>
    `
)