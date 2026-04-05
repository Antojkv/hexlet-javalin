package gg.jte.generated.ondemand;
import gg.jte.Content;
public final class JteindexGenerated {
	public static final String JTE_NAME = "index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,2,2,2,2,2,5,5,18,18,18,18,18,18,18,18};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n        <div style=\"text-align: center; padding: 40px 20px;\">\n            <h1 style=\"color: #333; margin-bottom: 20px;\">🎓 Добро пожаловать на платформу Хекслет!</h1>\n            <p style=\"color: #666; line-height: 1.6; margin-bottom: 30px; font-size: 18px;\">\n                Изучайте программирование с лучшими курсами. \n                Начните свой путь в IT уже сегодня!\n            </p>\n            <a href=\"/courses\" style=\"display: inline-block; padding: 12px 30px; \n               background-color: #4CAF50; color: white; text-decoration: none; \n               border-radius: 5px; font-size: 16px;\">\n                Посмотреть все курсы →\n            </a>\n        </div>\n    ");
			}
		}, "Главная");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		render(jteOutput, jteHtmlInterceptor);
	}
}
