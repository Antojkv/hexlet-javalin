@import gg.jte.Content
@param Content content
@param Object page = null

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Hexlet Learning</title>
    <style>
        .flash-success {
            background-color: #d4edda;
            color: #155724;
            border: 1px solid #c3e6cb;
            border-radius: 5px;
            padding: 12px;
            margin-bottom: 20px;
        }

        .flash-error {
            background-color: #f8d7da;
            color: #721c24;
            border: 1px solid #f5c6cb;
            border-radius: 5px;
            padding: 12px;
            margin-bottom: 20px;
        }

        * { margin: 0; padding: 0; box-sizing: border-box; }
        body { font-family: 'Segoe UI', sans-serif; background-color: #f5f5f5; min-height: 100vh; display: flex; flex-direction: column; }
        .header { background: linear-gradient(135deg, #667eea 0%, #764ba2 100%); color: white; padding: 20px 0; }
        .header-container { max-width: 1200px; margin: 0 auto; padding: 0 20px; }
        .header h1 a { color: white; text-decoration: none; }
        .nav-menu { display: flex; gap: 20px; margin-top: 10px; }
        .nav-menu a { color: white; text-decoration: none; padding: 8px 16px; border-radius: 5px; }
        .nav-menu a:hover { background-color: rgba(255,255,255,0.2); }
        .main-content { flex: 1; max-width: 1200px; margin: 40px auto; padding: 0 20px; width: 100%; }
        .footer { background-color: #333; color: #999; text-align: center; padding: 20px; margin-top: 40px; }
        .footer a { color: #4CAF50; text-decoration: none; }
    </style>
</head>
<body>
    <div class="header">
        <div class="header-container">
            <h1><a href="/">🎓 Hexlet Learning</a></h1>
            <div class="nav-menu">
                <a href="/">Главная</a>
                <a href="/courses">Курсы</a>
                <a href="/users">Пользователи</a>
            </div>
        </div>
    </div>

    <div class="main-content">
        @if(page != null)
            @if(org.example.hexlet.dto.BasePage.class.isInstance(page))
                @if(((org.example.hexlet.dto.BasePage) page).getFlash() != null)
                    <div class="flash-${((org.example.hexlet.dto.BasePage) page).getFlashType()}">
                        ${((org.example.hexlet.dto.BasePage) page).getFlash()}
                    </div>
                @endif
            @endif
        @endif

        ${content}
    </div>

    <div class="footer">
        <div class="footer-content">
            <p>© 2024 Hexlet Learning. Все права защищены.</p>
            <p><a href="https://github.com/your-username" target="_blank">📦 Мой GitHub профиль</a></p>
        </div>
    </div>
</body>
</html>