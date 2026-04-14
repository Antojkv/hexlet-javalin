package gg.jte.generated.ondemand;
import org.example.hexlet.NamedRoutes;
import org.example.hexlet.dto.MainPage;
public final class JteindexGenerated {
	public static final String JTE_NAME = "index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,2,2,4,4,7,7,10,10,12,12,12,19,19,20,20,24,24,28,28,28,28,28,28,28,28,28,33,33,37,37,37,38,38,38,2,2,2,2};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, MainPage page) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n        <h1>🎓 Добро пожаловать на платформу Хекслет!</h1>\n\n        ");
				if (page.getCurrentUser() != null) {
					jteOutput.writeContent("\n            <div style=\"background-color: #e8f5e9; border: 1px solid #4CAF50; border-radius: 5px; padding: 15px; margin: 20px 0;\">\n                <p>✅ <strong>Добро пожаловать, ");
					jteOutput.setContext("strong", null);
					jteOutput.writeUserContent(page.getCurrentUser());
					jteOutput.writeContent("!</strong> Вы успешно вошли на сайт.</p>\n                <form action=\"/sessions/delete\" method=\"post\" style=\"display: inline;\">\n                    <button type=\"submit\" style=\"background-color: #f44336; color: white; padding: 5px 10px; border: none; border-radius: 3px; cursor: pointer;\">\n                        Выйти\n                    </button>\n                </form>\n            </div>\n        ");
				} else {
					jteOutput.writeContent("\n            ");
					if (!page.isVisited()) {
						jteOutput.writeContent("\n                <div style=\"background-color: #e3f2fd; border: 1px solid #2196F3; border-radius: 5px; padding: 15px; margin: 20px 0;\">\n                    <p>✨ <strong>Добро пожаловать в первый раз!</strong> Это сообщение показывается только один раз.</p>\n                </div>\n            ");
					}
					jteOutput.writeContent("\n\n            <div style=\"margin: 20px 0;\">\n                <p>\n                    <a");
					var __jte_html_attribute_0 = NamedRoutes.buildSessionPath();
					if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
						jteOutput.writeContent(" href=\"");
						jteOutput.setContext("a", "href");
						jteOutput.writeUserContent(__jte_html_attribute_0);
						jteOutput.setContext("a", null);
						jteOutput.writeContent("\"");
					}
					jteOutput.writeContent(" style=\"background-color: #4CAF50; color: white; padding: 10px 20px; text-decoration: none; border-radius: 5px;\">\n                        Войти на сайт\n                    </a>\n                </p>\n            </div>\n        ");
				}
				jteOutput.writeContent("\n\n        <p><a href=\"/courses\">Посмотреть все курсы →</a></p>\n        <p><a href=\"/users\">Посмотреть пользователей →</a></p>\n    ");
			}
		}, "Главная");
		jteOutput.writeContent("\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		MainPage page = (MainPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
