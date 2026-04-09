package gg.jte.generated.ondemand.users;
import org.example.hexlet.dto.users.UsersPage;
public final class JteindexGenerated {
	public static final String JTE_NAME = "users/index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,3,3,6,6,15,15,17,17,27,27,29,29,29,30,30,30,31,31,31,33,33,36,36,37,37,37,37,37,1,1,1,1};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, UsersPage page) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n        <h1>Список пользователей</h1>\n\n        <p>\n            <a href=\"/users/build\" style=\"background-color: #4CAF50; color: white; padding: 10px 15px; text-decoration: none; border-radius: 5px;\">\n                + Добавить пользователя\n            </a>\n        </p>\n\n        ");
				if (page.getUsers().isEmpty()) {
					jteOutput.writeContent("\n            <p>Пока нет пользователей. Добавьте первого!</p>\n        ");
				} else {
					jteOutput.writeContent("\n            <table style=\"width: 100%; border-collapse: collapse;\">\n                <thead>\n                    <tr style=\"background-color: #f2f2f2;\">\n                        <th style=\"padding: 10px; text-align: left;\">ID</th>\n                        <th style=\"padding: 10px; text-align: left;\">Имя</th>\n                        <th style=\"padding: 10px; text-align: left;\">Email</th>\n                    </tr>\n                </thead>\n                <tbody>\n                    ");
					for (var user : page.getUsers()) {
						jteOutput.writeContent("\n                        <tr style=\"border-bottom: 1px solid #ddd;\">\n                            <td style=\"padding: 10px;\">");
						jteOutput.setContext("td", null);
						jteOutput.writeUserContent(user.getId());
						jteOutput.writeContent("</td>\n                            <td style=\"padding: 10px;\">");
						jteOutput.setContext("td", null);
						jteOutput.writeUserContent(user.getName());
						jteOutput.writeContent("</td>\n                            <td style=\"padding: 10px;\">");
						jteOutput.setContext("td", null);
						jteOutput.writeUserContent(user.getEmail());
						jteOutput.writeContent("</td>\n                        </tr>\n                    ");
					}
					jteOutput.writeContent("\n                </tbody>\n            </table>\n        ");
				}
				jteOutput.writeContent("\n    ");
			}
		}, "Пользователи");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		UsersPage page = (UsersPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
