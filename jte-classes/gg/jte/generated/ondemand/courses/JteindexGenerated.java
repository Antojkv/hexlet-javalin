package gg.jte.generated.ondemand.courses;
import org.example.hexlet.NamedRoutes;
import org.example.hexlet.dto.courses.CoursesPage;
public final class JteindexGenerated {
	public static final String JTE_NAME = "courses/index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,2,2,4,4,7,7,8,8,8,10,10,10,10,10,10,10,10,10,11,11,11,11,11,11,11,11,11,13,13,13,13,13,13,13,13,13,18,18,18,18,18,18,18,18,18,20,20,21,21,21,22,22,23,23,23,24,24,26,26,26,26,26,26,26,26,26,26,26,26,27,27,27,29,29,30,30,31,31,31,31,31,2,2,2,2};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, CoursesPage page) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n        <h1>");
				jteOutput.setContext("h1", null);
				jteOutput.writeUserContent(page.getHeader());
				jteOutput.writeContent("</h1>\n\n        <form");
				var __jte_html_attribute_0 = NamedRoutes.coursesPath();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
					jteOutput.writeContent(" action=\"");
					jteOutput.setContext("form", "action");
					jteOutput.writeUserContent(__jte_html_attribute_0);
					jteOutput.setContext("form", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" method=\"get\">\n            <input type=\"text\" name=\"term\"");
				var __jte_html_attribute_1 = page.getTerm();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
					jteOutput.writeContent(" value=\"");
					jteOutput.setContext("input", "value");
					jteOutput.writeUserContent(__jte_html_attribute_1);
					jteOutput.setContext("input", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" placeholder=\"Поиск...\"/>\n            <button type=\"submit\">Найти</button>\n            <a");
				var __jte_html_attribute_2 = NamedRoutes.coursesPath();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_2)) {
					jteOutput.writeContent(" href=\"");
					jteOutput.setContext("a", "href");
					jteOutput.writeUserContent(__jte_html_attribute_2);
					jteOutput.setContext("a", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(">Сбросить</a>\n        </form>\n\n        <hr/>\n\n        <p><a");
				var __jte_html_attribute_3 = NamedRoutes.buildCoursePath();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_3)) {
					jteOutput.writeContent(" href=\"");
					jteOutput.setContext("a", "href");
					jteOutput.writeUserContent(__jte_html_attribute_3);
					jteOutput.setContext("a", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(">+ Добавить курс</a></p>\n\n        ");
				if (page.getCourses().isEmpty()) {
					jteOutput.writeContent("\n            <p>По запросу \"");
					jteOutput.setContext("p", null);
					jteOutput.writeUserContent(page.getTerm());
					jteOutput.writeContent("\" ничего не найдено.</p>\n        ");
				} else {
					jteOutput.writeContent("\n            <p>Найдено курсов: ");
					jteOutput.setContext("p", null);
					jteOutput.writeUserContent(page.getCourses().size());
					jteOutput.writeContent("</p>\n            ");
					for (var course : page.getCourses()) {
						jteOutput.writeContent("\n                <div>\n                    <h2><a");
						var __jte_html_attribute_4 = NamedRoutes.coursePath(course.getId());
						if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_4)) {
							jteOutput.writeContent(" href=\"");
							jteOutput.setContext("a", "href");
							jteOutput.writeUserContent(__jte_html_attribute_4);
							jteOutput.setContext("a", null);
							jteOutput.writeContent("\"");
						}
						jteOutput.writeContent(">");
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
