@import gg.jte.Content

@template.layout.page(
    title = "Главная",
    content = @`
        <div style="text-align: center; padding: 40px 20px;">
            <h1 style="color: #333; margin-bottom: 20px;">🎓 Добро пожаловать на платформу Хекслет!</h1>
            <p style="color: #666; line-height: 1.6; margin-bottom: 30px; font-size: 18px;">
                Изучайте программирование с лучшими курсами. 
                Начните свой путь в IT уже сегодня!
            </p>
            <a href="/courses" style="display: inline-block; padding: 12px 30px; 
               background-color: #4CAF50; color: white; text-decoration: none; 
               border-radius: 5px; font-size: 16px;">
                Посмотреть все курсы →
            </a>
        </div>
    `
)