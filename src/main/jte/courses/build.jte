@import org.example.hexlet.NamedRoutes
@import org.example.hexlet.dto.courses.BuildCoursePage
@param BuildCoursePage page

@template.layout.page(
    title = "Добавление курса",
    content = @`
        <h1>Добавить новый курс</h1>

        @if(page.getErrors() != null)
            <div style="color: red;">
                <ul>
                    @for(var errors : page.getErrors().values())
                        @for(var error : errors)
                            <li>${error.getMessage()}</li>
                        @endfor
                    @endfor
                </ul>
            </div>
        @endif

        <form action="${NamedRoutes.coursesPath()}" method="post">
            <div>
                <label>Название:<br/>
                    <input type="text" name="name" value="${page.getName()}" />
                </label>
            </div>
            <div>
                <label>Описание:<br/>
                    <textarea name="description" rows="5">${page.getDescription()}</textarea>
                </label>
            </div>
            <button type="submit">Создать курс</button>
            <a href="${NamedRoutes.coursesPath()}">Отмена</a>
        </form>
    `
)