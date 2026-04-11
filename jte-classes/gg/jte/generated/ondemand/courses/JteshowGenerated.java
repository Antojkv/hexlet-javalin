package gg.jte.generated.ondemand.courses;
import org.example.hexlet.NamedRoutes;
import org.example.hexlet.dto.courses.CoursePage;
public final class JteshowGenerated {
	public static final String JTE_NAME = "courses/show.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,2,2,4,4,7,7,8,8,8,9,9,9,10,10,10,11,11,11,11,11,11,11,11,11,12,12,12,12,12,2,2,2,2};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, CoursePage page) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n        <h1>📖 ");
				jteOutput.setContext("h1", null);
				jteOutput.writeUserContent(page.getCourse().getName());
				jteOutput.writeContent("</h1>\n        <p>");
				jteOutput.setContext("p", null);
				jteOutput.writeUserContent(page.getCourse().getDescription());
				jteOutput.writeContent("</p>\n        <p><strong>ID:</strong> ");
				jteOutput.setContext("p", null);
				jteOutput.writeUserContent(page.getCourse().getId());
				jteOutput.writeContent("</p>\n        <p><a");
				var __jte_html_attribute_0 = NamedRoutes.coursesPath();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
					jteOutput.writeContent(" href=\"");
					jteOutput.setContext("a", "href");
					jteOutput.writeUserContent(__jte_html_attribute_0);
					jteOutput.setContext("a", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(">← Назад к списку</a></p>\n    ");
			}
		}, page.getCourse().getName());
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		CoursePage page = (CoursePage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
