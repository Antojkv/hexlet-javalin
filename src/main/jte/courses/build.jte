@import org.example.hexlet.NamedRoutes
@import org.example.hexlet.dto.courses.BuildCoursePage
@param BuildCoursePage page

@template.layout.page(
    page = page,
    content = @`
        <h1>Добавить новый курс</h1>

        @if(page.getErrors() != null && !page.getErrors().isEmpty())
            <div style="background-color: #f8d7da; color: #721c24; border: 1px solid #f5c6cb; border-radius: 5px; padding: 10px; margin-bottom: 20px;">
                <ul style="margin: 0;">
                    @for(var errors : page.getErrors().values())
                        @for(var error : errors)
                            <li>${error.getMessage()}</li>
                        @endfor
                    @endfor
                </ul>
            </div>
        @endif

        <form action="${NamedRoutes.coursesPath()}" method="post">
            <div style="margin-bottom: 15px;">
                <label>Название:<br/>
                    <input type="text" name="name" value="${page.getName() != null ? page.getName() : ""}" style="width: 100%; padding: 8px;" />
                </label>
            </div>
            <div style="margin-bottom: 15px;">
                <label>Описание:<br/>
                    <textarea name="description" rows="5" style="width: 100%; padding: 8px;">${page.getDescription() != null ? page.getDescription() : ""}</textarea>
                </label>
            </div>
            <button type="submit" style="background-color: #4CAF50; color: white; padding: 10px 20px; border: none; border-radius: 5px; cursor: pointer;">Создать курс</button>
            <a href="${NamedRoutes.coursesPath()}" style="margin-left: 10px;">Отмена</a>
        </form>
    `
)