package gg.jte.generated.ondemand.courses;
import org.example.hexlet.NamedRoutes;
import org.example.hexlet.dto.courses.BuildCoursePage;
public final class JtebuildGenerated {
	public static final String JTE_NAME = "courses/build.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,2,2,4,4,7,7,10,10,13,13,14,14,15,15,15,16,16,17,17,20,20,22,22,22,22,22,22,22,22,22,25,25,25,25,25,25,25,25,25,30,30,30,34,34,34,34,34,34,34,34,34,36,36,36,36,36,2,2,2,2};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, BuildCoursePage page) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n        <h1>Добавить новый курс</h1>\n\n        ");
				if (page.getErrors() != null) {
					jteOutput.writeContent("\n            <div style=\"color: red;\">\n                <ul>\n                    ");
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
				var __jte_html_attribute_0 = NamedRoutes.coursesPath();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
					jteOutput.writeContent(" action=\"");
					jteOutput.setContext("form", "action");
					jteOutput.writeUserContent(__jte_html_attribute_0);
					jteOutput.setContext("form", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" method=\"post\">\n            <div>\n                <label>Название:<br/>\n                    <input type=\"text\" name=\"name\"");
				var __jte_html_attribute_1 = page.getName();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
					jteOutput.writeContent(" value=\"");
					jteOutput.setContext("input", "value");
					jteOutput.writeUserContent(__jte_html_attribute_1);
					jteOutput.setContext("input", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" />\n                </label>\n            </div>\n            <div>\n                <label>Описание:<br/>\n                    <textarea name=\"description\" rows=\"5\">");
				jteOutput.setContext("textarea", null);
				jteOutput.writeUserContent(page.getDescription());
				jteOutput.writeContent("</textarea>\n                </label>\n            </div>\n            <button type=\"submit\">Создать курс</button>\n            <a");
				var __jte_html_attribute_2 = NamedRoutes.coursesPath();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_2)) {
					jteOutput.writeContent(" href=\"");
					jteOutput.setContext("a", "href");
					jteOutput.writeUserContent(__jte_html_attribute_2);
					jteOutput.setContext("a", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(">Отмена</a>\n        </form>\n    ");
			}
		}, "Добавление курса");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		BuildCoursePage page = (BuildCoursePage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
