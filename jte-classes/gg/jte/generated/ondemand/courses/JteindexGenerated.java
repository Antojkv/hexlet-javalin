package gg.jte.generated.ondemand.courses;
import org.example.hexlet.dto.courses.CoursesPage;
public final class JteindexGenerated {
	public static final String JTE_NAME = "courses/index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,3,3,6,6,9,11,11,11,11,11,11,11,11,11,18,19,19,21,21,22,22,22,23,23,25,25,25,25,25,25,25,26,26,26,28,28,29,29,30,30,30,30,30,1,1,1,1};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, CoursesPage page) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n        <h1>Все курсы</h1>\n\n        ");
				jteOutput.writeContent("\n        <form action=\"/courses\" method=\"get\">\n            <input type=\"text\" name=\"term\"");
				var __jte_html_attribute_0 = page.getTerm();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
					jteOutput.writeContent(" value=\"");
					jteOutput.setContext("input", "value");
					jteOutput.writeUserContent(__jte_html_attribute_0);
					jteOutput.setContext("input", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" placeholder=\"Поиск...\"/>\n            <button type=\"submit\">Найти</button>\n            <a href=\"/courses\">Сбросить</a>\n        </form>\n\n        <hr/>\n\n        ");
				jteOutput.writeContent("\n        ");
				if (page.getCourses().isEmpty()) {
					jteOutput.writeContent("\n            <p>Ничего не найдено</p>\n        ");
				} else {
					jteOutput.writeContent("\n            <p>Найдено: ");
					jteOutput.setContext("p", null);
					jteOutput.writeUserContent(page.getCourses().size());
					jteOutput.writeContent("</p>\n            ");
					for (var course : page.getCourses()) {
						jteOutput.writeContent("\n                <div>\n                    <h2><a href=\"/courses/");
						jteOutput.setContext("a", "href");
						jteOutput.writeUserContent(course.getId());
						jteOutput.setContext("a", null);
						jteOutput.writeContent("\">");
						jteOutput.setContext("a", null);
						jteOutput.writeUserContent(course.getName());
						jteOutput.writeContent("</a></h2>\n                    <p>");
						jteOutput.setContext("p", null);
						jteOutput.writeUserContent(course.getDescription());
						jteOutput.writeContent("</p>\n                </div>\n            ");
					}
					jteOutput.writeContent("\n        ");
				}
				jteOutput.writeContent("\n    ");
			}
		}, "Курсы");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		CoursesPage page = (CoursesPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
