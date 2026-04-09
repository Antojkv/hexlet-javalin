package gg.jte.generated.ondemand.users;
public final class JtebuildGenerated {
	public static final String JTE_NAME = "users/build.jte";
	public static final int[] JTE_LINE_INFO = {0,0,0,0,0,3,3,44,44,44,44,44,44,44,44};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor) {
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n        <h1>Регистрация нового пользователя</h1>\n\n        <form action=\"/users\" method=\"post\">\n            <div style=\"margin-bottom: 15px;\">\n                <label>\n                    Имя:\n                    <br/>\n                    <input type=\"text\" name=\"name\" required style=\"width: 100%; padding: 8px; margin-top: 5px;\" />\n                </label>\n            </div>\n\n            <div style=\"margin-bottom: 15px;\">\n                <label>\n                    Email:\n                    <br/>\n                    <input type=\"email\" name=\"email\" required style=\"width: 100%; padding: 8px; margin-top: 5px;\" />\n                </label>\n            </div>\n\n            <div style=\"margin-bottom: 15px;\">\n                <label>\n                    Пароль:\n                    <br/>\n                    <input type=\"password\" name=\"password\" required style=\"width: 100%; padding: 8px; margin-top: 5px;\" />\n                </label>\n            </div>\n\n            <div style=\"margin-bottom: 15px;\">\n                <label>\n                    Подтверждение пароля:\n                    <br/>\n                    <input type=\"password\" name=\"passwordConfirmation\" required style=\"width: 100%; padding: 8px; margin-top: 5px;\" />\n                </label>\n            </div>\n\n            <button type=\"submit\" style=\"background-color: #4CAF50; color: white; padding: 10px 20px; border: none; border-radius: 5px; cursor: pointer;\">\n                Зарегистрировать\n            </button>\n            <a href=\"/users\" style=\"margin-left: 10px;\">Отмена</a>\n        </form>\n    ");
			}
		}, "Регистрация пользователя");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		render(jteOutput, jteHtmlInterceptor);
	}
}
