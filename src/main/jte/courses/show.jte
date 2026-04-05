@import org.example.hexlet.dto.courses.CoursePage
@param CoursePage page

@template.layout.page(
    title = page.getCourse().getName(),
    content = @`
        <div style="background-color: white; border-radius: 8px; padding: 30px; box-shadow: 0 2px 4px rgba(0,0,0,0.1);">
            <h1 style="color: #333; border-bottom: 3px solid #4CAF50; padding-bottom: 10px;">
                📖 ${page.getCourse().getName()}
            </h1>

            <div style="margin: 20px 0;">
                <div style="font-size: 18px; line-height: 1.6; color: #555;
                           background-color: #f9f9f9; padding: 20px; border-radius: 8px;">
                    <strong>Описание курса:</strong><br>
                    ${page.getCourse().getDescription()}
                </div>

                <div style="color: #999; margin-top: 20px;">
                    <strong>ID курса:</strong> ${page.getCourse().getId()}
                </div>
            </div>

            <a href="/courses" style="display: inline-block; margin-top: 20px; color: #4CAF50;
               text-decoration: none; padding: 10px 20px; border: 1px solid #4CAF50;
               border-radius: 5px;">
                ← Назад к списку курсов
            </a>
        </div>
    `
)