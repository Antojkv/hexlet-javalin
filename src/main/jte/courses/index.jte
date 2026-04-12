@import org.example.hexlet.NamedRoutes
@import org.example.hexlet.dto.courses.CoursesPage
@param CoursesPage page

@template.layout.page(
    title = "Курсы",
    content = @`
        <h1>${page.getHeader()}</h1>

        <form action="${NamedRoutes.coursesPath()}" method="get">
            <input type="text" name="term" value="${page.getTerm()}" placeholder="Поиск..."/>
            <button type="submit">Найти</button>
            <a href="${NamedRoutes.coursesPath()}">Сбросить</a>
        </form>

        <hr/>

        <p><a href="${NamedRoutes.buildCoursePath()}">+ Добавить курс</a></p>

        @if(page.getCourses().isEmpty())
            <p>По запросу "${page.getTerm()}" ничего не найдено.</p>
        @else
            <p>Найдено курсов: ${page.getCourses().size()}</p>
            @for(var course : page.getCourses())
                <div style="border: 1px solid #ccc; margin-bottom: 10px; padding: 10px;">
                    <h2><a href="${NamedRoutes.coursePath(course.getId())}">${course.getName()}</a></h2>
                    <p>${course.getDescription()}</p>
                    <p>
                        <a href="${NamedRoutes.editCoursePath(course.getId())}">Редактировать</a>
                        <form action="${NamedRoutes.coursePath(course.getId())}" method="post" style="display: inline;">
                            <input type="hidden" name="_method" value="delete" />
                            <button type="submit" onclick="return confirm('Удалить курс?')">Удалить</button>
                        </form>
                    </p>
                </div>
            @endfor
        @endif
    `
)