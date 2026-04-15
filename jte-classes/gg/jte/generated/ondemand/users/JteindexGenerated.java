package gg.jte.generated.ondemand.users;
import org.example.hexlet.NamedRoutes;
import org.example.hexlet.dto.users.UsersPage;
public final class JteindexGenerated {
	public static final String JTE_NAME = "users/index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,2,2,4,4,7,7,10,10,10,10,10,10,10,10,10,12,12,14,14,25,25,27,27,27,28,28,28,29,29,29,31,31,31,31,31,31,31,31,31,32,32,32,32,32,32,32,32,32,38,38,41,41,42,42,42,42,42,2,2,2,2};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, UsersPage page) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n        <h1>Список пользователей</h1>\n\n        <p><a");
				var __jte_html_attribute_0 = NamedRoutes.buildUserPath();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
					jteOutput.writeContent(" href=\"");
					jteOutput.setContext("a", "href");
					jteOutput.writeUserContent(__jte_html_attribute_0);
					jteOutput.setContext("a", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(">+ Добавить пользователя</a></p>\n\n        ");
				if (page.getUsers().isEmpty()) {
					jteOutput.writeContent("\n            <p>Пока нет пользователей. Добавьте первого!</p>\n        ");
				} else {
					jteOutput.writeContent("\n            <table border=\"1\">\n                <thead>\n                    <tr>\n                        <th>ID</th>\n                        <th>Имя</th>\n                        <th>Email</th>\n                        <th>Действия</th>\n                    </tr>\n                </thead>\n                <tbody>\n                    ");
					for (var user : page.getUsers()) {
						jteOutput.writeContent("\n                        <tr>\n                            <td>");
						jteOutput.setContext("td", null);
						jteOutput.writeUserContent(user.getId());
						jteOutput.writeContent("</td>\n                            <td>");
						jteOutput.setContext("td", null);
						jteOutput.writeUserContent(user.getName());
						jteOutput.writeContent("</td>\n                            <td>");
						jteOutput.setContext("td", null);
						jteOutput.writeUserContent(user.getEmail());
						jteOutput.writeContent("</td>\n                            <td>\n                                <a");
						var __jte_html_attribute_1 = NamedRoutes.editUserPath(user.getId());
						if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
							jteOutput.writeContent(" href=\"");
							jteOutput.setContext("a", "href");
							jteOutput.writeUserContent(__jte_html_attribute_1);
							jteOutput.setContext("a", null);
							jteOutput.writeContent("\"");
						}
						jteOutput.writeContent(">Редактировать</a>\n                                <form");
						var __jte_html_attribute_2 = NamedRoutes.userPath(user.getId());
						if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_2)) {
							jteOutput.writeContent(" action=\"");
							jteOutput.setContext("form", "action");
							jteOutput.writeUserContent(__jte_html_attribute_2);
							jteOutput.setContext("form", null);
							jteOutput.writeContent("\"");
						}
						jteOutput.writeContent(" method=\"post\" style=\"display: inline;\">\n                                    <input type=\"hidden\" name=\"_method\" value=\"delete\" />\n                                    <button type=\"submit\" onclick=\"return confirm('Удалить пользователя?')\">Удалить</button>\n                                </form>\n                            </td>\n                        </tr>\n                    ");
					}
					jteOutput.writeContent("\n                </tbody>\n            </table>\n        ");
				}
				jteOutput.writeContent("\n    ");
			}
		}, page);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		UsersPage page = (UsersPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
