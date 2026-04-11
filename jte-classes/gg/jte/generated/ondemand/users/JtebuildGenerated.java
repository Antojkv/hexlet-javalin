package gg.jte.generated.ondemand.users;
import org.example.hexlet.dto.users.BuildUserPage;
public final class JtebuildGenerated {
	public static final String JTE_NAME = "users/build.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,3,3,6,6,9,10,10,13,13,14,14,15,15,15,16,16,17,17,20,20,22,28,28,28,28,28,28,28,28,28,36,36,36,36,36,36,36,36,36,59,59,59,59,59,1,1,1,1};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, BuildUserPage page) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n        <h1>Регистрация нового пользователя</h1>\n\n        ");
				jteOutput.writeContent("\n        ");
				if (page.getErrors() != null) {
					jteOutput.writeContent("\n            <div style=\"color: red; border: 1px solid red; padding: 10px; margin-bottom: 20px;\">\n                <ul>\n                    ");
					for (var errors : page.getErrors().values()) {
						jteOutput.writeContent("\n                        ");
						for (var error : errors) {
							jteOutput.writeContent("\n                            <li>");
							jteOutput.setContext("li", null);
							jteOutput.writeUserContent(error.getMessage());
							jteOutput.writeContent("</li>\n                        ");
						}
						jteOutput.writeContent("\n                    ");
					}
					jteOutput.writeContent("\n                </ul>\n            </div>\n        ");
				}
				jteOutput.writeContent("\n\n        ");
				jteOutput.writeContent("\n        <form action=\"/users\" method=\"post\">\n            <div style=\"margin-bottom: 15px;\">\n                <label>\n                    Имя:\n                    <br/>\n                    <input type=\"text\" name=\"name\"");
				var __jte_html_attribute_0 = page.getName();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
					jteOutput.writeContent(" value=\"");
					jteOutput.setContext("input", "value");
					jteOutput.writeUserContent(__jte_html_attribute_0);
					jteOutput.setContext("input", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" style=\"width: 100%; padding: 5px;\" />\n                </label>\n            </div>\n\n            <div style=\"margin-bottom: 15px;\">\n                <label>\n                    Email:\n                    <br/>\n                    <input type=\"email\" name=\"email\"");
				var __jte_html_attribute_1 = page.getEmail();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
					jteOutput.writeContent(" value=\"");
					jteOutput.setContext("input", "value");
					jteOutput.writeUserContent(__jte_html_attribute_1);
					jteOutput.setContext("input", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" style=\"width: 100%; padding: 5px;\" />\n                </label>\n            </div>\n\n            <div style=\"margin-bottom: 15px;\">\n                <label>\n                    Пароль:\n                    <br/>\n                    <input type=\"password\" name=\"password\" style=\"width: 100%; padding: 5px;\" />\n                </label>\n            </div>\n\n            <div style=\"margin-bottom: 15px;\">\n                <label>\n                    Подтверждение пароля:\n                    <br/>\n                    <input type=\"password\" name=\"passwordConfirmation\" style=\"width: 100%; padding: 5px;\" />\n                </label>\n            </div>\n\n            <button type=\"submit\">Зарегистрировать</button>\n            <a href=\"/users\">Отмена</a>\n        </form>\n    ");
			}
		}, "Регистрация");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		BuildUserPage page = (BuildUserPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
