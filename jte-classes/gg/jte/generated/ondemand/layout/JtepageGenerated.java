package gg.jte.generated.ondemand.layout;
import gg.jte.Content;
import org.example.hexlet.dto.BasePage;
public final class JtepageGenerated {
	public static final String JTE_NAME = "layout/page.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,2,2,12,12,116,117,117,118,118,118,118,119,119,119,121,121,123,123,123,137,137,137,2,3,3,3,3};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, Content content, BasePage page) {
		jteOutput.writeContent("\n<!DOCTYPE html>\n<html lang=\"ru\">\n<head>\n    <meta charset=\"UTF-8\">\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n    <title>Hexlet Learning</title>\n    <style>\n        ");
		jteOutput.writeContent("\n        .flash-success {\n            background-color: #d4edda;\n            color: #155724;\n            border: 1px solid #c3e6cb;\n            border-radius: 5px;\n            padding: 12px;\n            margin-bottom: 20px;\n        }\n\n        .flash-error {\n            background-color: #f8d7da;\n            color: #721c24;\n            border: 1px solid #f5c6cb;\n            border-radius: 5px;\n            padding: 12px;\n            margin-bottom: 20px;\n        }\n\n        * {\n            margin: 0;\n            padding: 0;\n            box-sizing: border-box;\n        }\n\n        body {\n            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;\n            background-color: #f5f5f5;\n            min-height: 100vh;\n            display: flex;\n            flex-direction: column;\n        }\n\n        .header {\n            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);\n            color: white;\n            padding: 20px 0;\n            box-shadow: 0 2px 10px rgba(0,0,0,0.1);\n        }\n\n        .header-container {\n            max-width: 1200px;\n            margin: 0 auto;\n            padding: 0 20px;\n        }\n\n        .header h1 a {\n            color: white;\n            text-decoration: none;\n        }\n\n        .nav-menu {\n            display: flex;\n            gap: 20px;\n            margin-top: 10px;\n        }\n\n        .nav-menu a {\n            color: white;\n            text-decoration: none;\n            padding: 8px 16px;\n            border-radius: 5px;\n            transition: background-color 0.3s;\n        }\n\n        .nav-menu a:hover {\n            background-color: rgba(255,255,255,0.2);\n        }\n\n        .main-content {\n            flex: 1;\n            max-width: 1200px;\n            margin: 40px auto;\n            padding: 0 20px;\n            width: 100%;\n        }\n\n        .footer {\n            background-color: #333;\n            color: #999;\n            text-align: center;\n            padding: 20px;\n            margin-top: 40px;\n        }\n\n        .footer a {\n            color: #4CAF50;\n            text-decoration: none;\n        }\n    </style>\n</head>\n<body>\n    <div class=\"header\">\n        <div class=\"header-container\">\n            <h1><a href=\"/\">🎓 Hexlet Learning</a></h1>\n            <div class=\"nav-menu\">\n                <a href=\"/\">Главная</a>\n                <a href=\"/courses\">Курсы</a>\n                <a href=\"/users\">Пользователи</a>\n            </div>\n        </div>\n    </div>\n\n    <div class=\"main-content\">\n        ");
		jteOutput.writeContent("\n        ");
		if (page != null && page.getFlash() != null) {
			jteOutput.writeContent("\n            <div class=\"flash-");
			jteOutput.setContext("div", "class");
			jteOutput.writeUserContent(page.getFlashType());
			jteOutput.setContext("div", null);
			jteOutput.writeContent("\">\n                ");
			jteOutput.setContext("div", null);
			jteOutput.writeUserContent(page.getFlash());
			jteOutput.writeContent("\n            </div>\n        ");
		}
		jteOutput.writeContent("\n\n        ");
		jteOutput.setContext("div", null);
		jteOutput.writeUserContent(content);
		jteOutput.writeContent("\n    </div>\n\n    <div class=\"footer\">\n        <div class=\"footer-content\">\n            <p>© 2024 Hexlet Learning. Все права защищены.</p>\n            <p>\n                <a href=\"https://github.com/your-username\" target=\"_blank\">\n                    📦 Мой GitHub профиль\n                </a>\n            </p>\n        </div>\n    </div>\n</body>\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		Content content = (Content)params.get("content");
		BasePage page = (BasePage)params.getOrDefault("page", null);
		render(jteOutput, jteHtmlInterceptor, content, page);
	}
}
