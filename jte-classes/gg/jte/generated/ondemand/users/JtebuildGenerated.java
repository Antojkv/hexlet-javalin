package gg.jte.generated.ondemand.users;
import org.example.hexlet.NamedRoutes;
import org.example.hexlet.dto.users.BuildUserPage;
public final class JtebuildGenerated {
	public static final String JTE_NAME = "users/build.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,2,2,4,4,7,7,10,10,13,13,14,14,15,15,15,16,16,17,17,20,20,22,22,22,22,22,22,22,22,22,25,25,25,25,25,25,25,25,25,30,30,30,30,30,30,30,30,30,44,44,44,44,44,44,44,44,44,46,46,46,46,46,2,2,2,2};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, BuildUserPage page) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n        <h1>Регистрация нового пользователя</h1>\n\n        ");
				if (page.getErrors() != null && !page.getErrors().isEmpty()) {
					jteOutput.writeContent("\n            <div style=\"background-color: #f8d7da; color: #721c24; border: 1px solid #f5c6cb; border-radius: 5px; padding: 10px; margin-bottom: 20px;\">\n                <ul style=\"margin: 0;\">\n                    ");
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
				jteOutput.writeContent("\n\n        <form");
				var __jte_html_attribute_0 = NamedRoutes.usersPath();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
					jteOutput.writeContent(" action=\"");
					jteOutput.setContext("form", "action");
					jteOutput.writeUserContent(__jte_html_attribute_0);
					jteOutput.setContext("form", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" method=\"post\">\n            <div style=\"margin-bottom: 15px;\">\n                <label>Имя:<br/>\n                    <input type=\"text\" name=\"name\"");
				var __jte_html_attribute_1 = page.getName() != null ? page.getName() : "";
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
					jteOutput.writeContent(" value=\"");
					jteOutput.setContext("input", "value");
					jteOutput.writeUserContent(__jte_html_attribute_1);
					jteOutput.setContext("input", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" style=\"width: 100%; padding: 8px;\" />\n                </label>\n            </div>\n            <div style=\"margin-bottom: 15px;\">\n                <label>Email:<br/>\n                    <input type=\"email\" name=\"email\"");
				var __jte_html_attribute_2 = page.getEmail() != null ? page.getEmail() : "";
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_2)) {
					jteOutput.writeContent(" value=\"");
					jteOutput.setContext("input", "value");
					jteOutput.writeUserContent(__jte_html_attribute_2);
					jteOutput.setContext("input", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" style=\"width: 100%; padding: 8px;\" />\n                </label>\n            </div>\n            <div style=\"margin-bottom: 15px;\">\n                <label>Пароль:<br/>\n                    <input type=\"password\" name=\"password\" style=\"width: 100%; padding: 8px;\" />\n                </label>\n            </div>\n            <div style=\"margin-bottom: 15px;\">\n                <label>Подтверждение пароля:<br/>\n                    <input type=\"password\" name=\"passwordConfirmation\" style=\"width: 100%; padding: 8px;\" />\n                </label>\n            </div>\n            <button type=\"submit\" style=\"background-color: #4CAF50; color: white; padding: 10px 20px; border: none; border-radius: 5px; cursor: pointer;\">Зарегистрировать</button>\n            <a");
				var __jte_html_attribute_3 = NamedRoutes.usersPath();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_3)) {
					jteOutput.writeContent(" href=\"");
					jteOutput.setContext("a", "href");
					jteOutput.writeUserContent(__jte_html_attribute_3);
					jteOutput.setContext("a", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" style=\"margin-left: 10px;\">Отмена</a>\n        </form>\n    ");
			}
		}, page);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		BuildUserPage page = (BuildUserPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
