@import org.example.hexlet.NamedRoutes
@import org.example.hexlet.model.Course
@param Course course

@template.layout.page(
    title = "Редактирование курса",
    content = @`
        <h1>Редактирование курса: ${course.getName()}</h1>

        <form action="${NamedRoutes.coursePath(course.getId())}" method="post">
            <input type="hidden" name="_method" value="patch" />

            <div>
                <label>Название:<br/>
                    <input type="text" name="name" value="${course.getName()}" />
                </label>
            </div>
            <div>
                <label>Описание:<br/>
                    <textarea name="description" rows="5">${course.getDescription()}</textarea>
                </label>
            </div>

            <button type="submit">Сохранить</button>
            <a href="${NamedRoutes.coursesPath()}">Отмена</a>
        </form>
    `
)