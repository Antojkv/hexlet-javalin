package gg.jte.generated.ondemand.courses;
import org.example.hexlet.dto.courses.CoursePage;
public final class JteshowGenerated {
	public static final String JTE_NAME = "courses/show.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,3,3,6,6,9,9,9,16,16,16,20,20,20,30,30,30,30,30,1,1,1,1};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, CoursePage page) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n        <div style=\"background-color: white; border-radius: 8px; padding: 30px; box-shadow: 0 2px 4px rgba(0,0,0,0.1);\">\n            <h1 style=\"color: #333; border-bottom: 3px solid #4CAF50; padding-bottom: 10px;\">\n                📖 ");
				jteOutput.setContext("h1", null);
				jteOutput.writeUserContent(page.getCourse().getName());
				jteOutput.writeContent("\n            </h1>\n\n            <div style=\"margin: 20px 0;\">\n                <div style=\"font-size: 18px; line-height: 1.6; color: #555;\n                           background-color: #f9f9f9; padding: 20px; border-radius: 8px;\">\n                    <strong>Описание курса:</strong><br>\n                    ");
				jteOutput.setContext("div", null);
				jteOutput.writeUserContent(page.getCourse().getDescription());
				jteOutput.writeContent("\n                </div>\n\n                <div style=\"color: #999; margin-top: 20px;\">\n                    <strong>ID курса:</strong> ");
				jteOutput.setContext("div", null);
				jteOutput.writeUserContent(page.getCourse().getId());
				jteOutput.writeContent("\n                </div>\n            </div>\n\n            <a href=\"/courses\" style=\"display: inline-block; margin-top: 20px; color: #4CAF50;\n               text-decoration: none; padding: 10px 20px; border: 1px solid #4CAF50;\n               border-radius: 5px;\">\n                ← Назад к списку курсов\n            </a>\n        </div>\n    ");
			}
		}, page.getCourse().getName());
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		CoursePage page = (CoursePage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
