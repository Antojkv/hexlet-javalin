package gg.jte.generated.ondemand.courses;
import org.example.hexlet.dto.courses.CoursePage;
public final class JteshowGenerated {
	public static final String JTE_NAME = "courses/show.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,8,8,8,8,69,69,69,74,74,74,78,78,78,85,85,85,1,1,1,1};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, CoursePage page) {
		jteOutput.writeContent("\n<!DOCTYPE html>\n<html lang=\"ru\">\n<head>\n    <meta charset=\"UTF-8\">\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n    <title>");
		jteOutput.setContext("title", null);
		jteOutput.writeUserContent(page.getCourse().getName());
		jteOutput.writeContent(" - Хекслет</title>\n    <style>\n        body {\n            font-family: Arial, sans-serif;\n            max-width: 1200px;\n            margin: 0 auto;\n            padding: 20px;\n            background-color: #f5f5f5;\n        }\n        .container {\n            background-color: white;\n            border-radius: 8px;\n            padding: 30px;\n            box-shadow: 0 2px 4px rgba(0,0,0,0.1);\n        }\n        h1 {\n            color: #333;\n            border-bottom: 3px solid #4CAF50;\n            padding-bottom: 10px;\n        }\n        .course-info {\n            margin: 20px 0;\n        }\n        .course-description {\n            font-size: 18px;\n            line-height: 1.6;\n            color: #555;\n            background-color: #f9f9f9;\n            padding: 20px;\n            border-radius: 8px;\n            margin: 20px 0;\n        }\n        .course-id {\n            color: #999;\n            font-size: 14px;\n            margin-top: 20px;\n        }\n        .back-link {\n            display: inline-block;\n            margin-top: 20px;\n            color: #4CAF50;\n            text-decoration: none;\n            padding: 10px 20px;\n            border: 1px solid #4CAF50;\n            border-radius: 5px;\n            transition: all 0.3s;\n        }\n        .back-link:hover {\n            background-color: #4CAF50;\n            color: white;\n        }\n        .not-found {\n            text-align: center;\n            color: #d32f2f;\n            padding: 50px;\n            font-size: 24px;\n        }\n    </style>\n</head>\n<body>\n    <div class=\"container\">\n        <h1>📖 ");
		jteOutput.setContext("h1", null);
		jteOutput.writeUserContent(page.getCourse().getName());
		jteOutput.writeContent("</h1>\n\n        <div class=\"course-info\">\n            <div class=\"course-description\">\n                <strong>Описание курса:</strong><br>\n                ");
		jteOutput.setContext("div", null);
		jteOutput.writeUserContent(page.getCourse().getDescription());
		jteOutput.writeContent("\n            </div>\n\n            <div class=\"course-id\">\n                <strong>ID курса:</strong> ");
		jteOutput.setContext("div", null);
		jteOutput.writeUserContent(page.getCourse().getId());
		jteOutput.writeContent("\n            </div>\n        </div>\n\n        <a href=\"/courses\" class=\"back-link\">← Назад к списку курсов</a>\n    </div>\n</body>\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		CoursePage page = (CoursePage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
