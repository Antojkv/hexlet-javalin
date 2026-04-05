package gg.jte.generated.ondemand.courses;
import org.example.hexlet.dto.courses.CoursesPage;
public final class JteindexGenerated {
	public static final String JTE_NAME = "courses/index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,3,3,6,6,8,8,8,11,11,15,15,17,17,21,21,21,21,22,22,22,25,25,25,26,26,26,28,28,30,30,31,31,31,31,31,1,1,1,1};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, CoursesPage page) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n        <h1 style=\"color: #333; border-bottom: 3px solid #4CAF50; padding-bottom: 10px; margin-bottom: 20px;\">\n            ");
				jteOutput.setContext("h1", null);
				jteOutput.writeUserContent(page.getHeader());
				jteOutput.writeContent("\n        </h1>\n\n        ");
				if (page.getCourses().isEmpty()) {
					jteOutput.writeContent("\n            <div style=\"text-align: center; color: #999; padding: 50px;\">\n                <p>📚 Пока не добавлено ни одного курса</p>\n            </div>\n        ");
				} else {
					jteOutput.writeContent("\n            <div style=\"display: grid; grid-template-columns: repeat(auto-fill, minmax(300px, 1fr)); gap: 20px;\">\n                ");
					for (var course : page.getCourses()) {
						jteOutput.writeContent("\n                    <div style=\"border: 1px solid #ddd; border-radius: 8px; padding: 15px;\n                              transition: transform 0.3s, box-shadow 0.3s;\">\n                        <h2 style=\"color: #4CAF50; margin-top: 0;\">\n                            <a href=\"/courses/");
						jteOutput.setContext("a", "href");
						jteOutput.writeUserContent(course.getId());
						jteOutput.setContext("a", null);
						jteOutput.writeContent("\" style=\"color: #4CAF50; text-decoration: none;\">\n                                ");
						jteOutput.setContext("a", null);
						jteOutput.writeUserContent(course.getName());
						jteOutput.writeContent("\n                            </a>\n                        </h2>\n                        <p style=\"color: #666; line-height: 1.5;\">");
						jteOutput.setContext("p", null);
						jteOutput.writeUserContent(course.getDescription());
						jteOutput.writeContent("</p>\n                        <small style=\"color: #999;\">ID курса: ");
						jteOutput.setContext("small", null);
						jteOutput.writeUserContent(course.getId());
						jteOutput.writeContent("</small>\n                    </div>\n                ");
					}
					jteOutput.writeContent("\n            </div>\n        ");
				}
				jteOutput.writeContent("\n    ");
			}
		}, page.getHeader());
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		CoursesPage page = (CoursesPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
