package gg.jte.generated.ondemand;
import org.example.hexlet.dto.MainPage;
public final class JteindexGenerated {
	public static final String JTE_NAME = "index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,3,3,6,6,10,10,15,15,19,19,19,19,19,1,1,1,1};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, MainPage page) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n        <h1>🎓 Добро пожаловать на платформу Хекслет!</h1>\n        <p>Изучайте программирование с лучшими курсами. Начните свой путь в IT уже сегодня!</p>\n\n        ");
				if (!page.isVisited()) {
					jteOutput.writeContent("\n            <div style=\"background-color: #e8f5e9; border: 1px solid #4CAF50; border-radius: 5px; padding: 15px; margin: 20px 0;\">\n                <p>✨ <strong>Добро пожаловать в первый раз!</strong> Это сообщение показывается только один раз.</p>\n                <p>Если вы хотите увидеть его снова, очистите cookies в браузере.</p>\n            </div>\n        ");
				}
				jteOutput.writeContent("\n\n        <p><a href=\"/courses\">Посмотреть все курсы →</a></p>\n        <p><a href=\"/users\">Посмотреть пользователей →</a></p>\n    ");
			}
		}, "Главная");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		MainPage page = (MainPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
