@import org.example.hexlet.NamedRoutes
@import org.example.hexlet.dto.courses.CoursePage
@param CoursePage page

@template.layout.page(
    title = page.getCourse().getName(),
    content = @`
        <h1>📖 ${page.getCourse().getName()}</h1>
        <p>${page.getCourse().getDescription()}</p>
        <p><strong>ID:</strong> ${page.getCourse().getId()}</p>
        <p><a href="${NamedRoutes.coursesPath()}">← Назад к списку</a></p>
    `
)