package gg.jte.generated.ondemand.layout;
import gg.jte.Content;
public final class JtepageGenerated {
	public static final String JTE_NAME = "layout/page.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,55,55,55,56,56,57,57,58,58,58,58,59,59,59,61,61,62,62,63,63,65,65,65,75,75,75,1,2,2,2,2};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, Content content, Object page) {
		jteOutput.writeContent("\n<!DOCTYPE html>\n<html lang=\"ru\">\n<head>\n    <meta charset=\"UTF-8\">\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n    <title>Hexlet Learning</title>\n    <style>\n        .flash-success {\n            background-color: #d4edda;\n            color: #155724;\n            border: 1px solid #c3e6cb;\n            border-radius: 5px;\n            padding: 12px;\n            margin-bottom: 20px;\n        }\n\n        .flash-error {\n            background-color: #f8d7da;\n            color: #721c24;\n            border: 1px solid #f5c6cb;\n            border-radius: 5px;\n            padding: 12px;\n            margin-bottom: 20px;\n        }\n\n        * { margin: 0; padding: 0; box-sizing: border-box; }\n        body { font-family: 'Segoe UI', sans-serif; background-color: #f5f5f5; min-height: 100vh; display: flex; flex-direction: column; }\n        .header { background: linear-gradient(135deg, #667eea 0%, #764ba2 100%); color: white; padding: 20px 0; }\n        .header-container { max-width: 1200px; margin: 0 auto; padding: 0 20px; }\n        .header h1 a { color: white; text-decoration: none; }\n        .nav-menu { display: flex; gap: 20px; margin-top: 10px; }\n        .nav-menu a { color: white; text-decoration: none; padding: 8px 16px; border-radius: 5px; }\n        .nav-menu a:hover { background-color: rgba(255,255,255,0.2); }\n        .main-content { flex: 1; max-width: 1200px; margin: 40px auto; padding: 0 20px; width: 100%; }\n        .footer { background-color: #333; color: #999; text-align: center; padding: 20px; margin-top: 40px; }\n        .footer a { color: #4CAF50; text-decoration: none; }\n    </style>\n</head>\n<body>\n    <div class=\"header\">\n        <div class=\"header-container\">\n            <h1><a href=\"/\">🎓 Hexlet Learning</a></h1>\n            <div class=\"nav-menu\">\n                <a href=\"/\">Главная</a>\n                <a href=\"/courses\">Курсы</a>\n                <a href=\"/users\">Пользователи</a>\n            </div>\n        </div>\n    </div>\n\n    <div class=\"main-content\">\n        ");
		if (page != null) {
			jteOutput.writeContent("\n            ");
			if (org.example.hexlet.dto.BasePage.class.isInstance(page)) {
				jteOutput.writeContent("\n                ");
				if (((org.example.hexlet.dto.BasePage) page).getFlash() != null) {
					jteOutput.writeContent("\n                    <div class=\"flash-");
					jteOutput.setContext("div", "class");
					jteOutput.writeUserContent(((org.example.hexlet.dto.BasePage) page).getFlashType());
					jteOutput.setContext("div", null);
					jteOutput.writeContent("\">\n                        ");
					jteOutput.setContext("div", null);
					jteOutput.writeUserContent(((org.example.hexlet.dto.BasePage) page).getFlash());
					jteOutput.writeContent("\n                    </div>\n                ");
				}
				jteOutput.writeContent("\n            ");
			}
			jteOutput.writeContent("\n        ");
		}
		jteOutput.writeContent("\n\n        ");
		jteOutput.setContext("div", null);
		jteOutput.writeUserContent(content);
		jteOutput.writeContent("\n    </div>\n\n    <div class=\"footer\">\n        <div class=\"footer-content\">\n            <p>© 2024 Hexlet Learning. Все права защищены.</p>\n            <p><a href=\"https://github.com/your-username\" target=\"_blank\">📦 Мой GitHub профиль</a></p>\n        </div>\n    </div>\n</body>\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		Content content = (Content)params.get("content");
		Object page = (Object)params.getOrDefault("page", null);
		render(jteOutput, jteHtmlInterceptor, content, page);
	}
}
