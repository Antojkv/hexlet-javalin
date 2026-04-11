@import org.example.hexlet.dto.courses.BuildCoursePage
@param BuildCoursePage page

@template.layout.page(
    title = "Добавление курса",
    content = @`
        <h1>Добавить новый курс</h1>

        <!-- ВЫВОД ОШИБОК -->
        @if(page.getErrors() != null)
            <div style="color: red; border: 1px solid red; padding: 10px; margin-bottom: 20px;">
                <ul>
                    @for(var errors : page.getErrors().values())
                        @for(var error : errors)
                            <li>${error.getMessage()}</li>
                        @endfor
                    @endfor
                </ul>
            </div>
        @endif

        <!-- ФОРМА -->
        <form action="/courses" method="post">
            <div style="margin-bottom: 15px;">
                <label>
                    Название курса:
                    <br/>
                    <input type="text" name="name" value="${page.getName()}" style="width: 100%; padding: 5px;" />
                </label>
            </div>

            <div style="margin-bottom: 15px;">
                <label>
                    Описание:
                    <br/>
                    <textarea name="description" rows="5" style="width: 100%; padding: 5px;">${page.getDescription()}</textarea>
                </label>
            </div>

            <button type="submit">Создать курс</button>
            <a href="/courses">Отмена</a>
        </form>
    `
)