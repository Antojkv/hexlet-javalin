@import org.example.hexlet.dto.courses.CoursesPage
@param CoursesPage page

@template.layout.page(
    title = page.getHeader(),
    content = @`
        <h1 style="color: #333; border-bottom: 3px solid #4CAF50; padding-bottom: 10px; margin-bottom: 20px;">
            ${page.getHeader()}
        </h1>

        @if(page.getCourses().isEmpty())
            <div style="text-align: center; color: #999; padding: 50px;">
                <p>📚 Пока не добавлено ни одного курса</p>
            </div>
        @else
            <div style="display: grid; grid-template-columns: repeat(auto-fill, minmax(300px, 1fr)); gap: 20px;">
                @for(var course : page.getCourses())
                    <div style="border: 1px solid #ddd; border-radius: 8px; padding: 15px;
                              transition: transform 0.3s, box-shadow 0.3s;">
                        <h2 style="color: #4CAF50; margin-top: 0;">
                            <a href="/courses/${course.getId()}" style="color: #4CAF50; text-decoration: none;">
                                ${course.getName()}
                            </a>
                        </h2>
                        <p style="color: #666; line-height: 1.5;">${course.getDescription()}</p>
                        <small style="color: #999;">ID курса: ${course.getId()}</small>
                    </div>
                @endfor
            </div>
        @endif
    `
)