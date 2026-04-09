@import org.example.hexlet.dto.courses.CoursesPage
@param CoursesPage page

@template.layout.page(
    title = "Курсы",
    content = @`
        <h1>Все курсы</h1>

        <!-- Форма поиска -->
        <form action="/courses" method="get">
            <input type="text" name="term" value="${page.getTerm()}" placeholder="Поиск..."/>
            <button type="submit">Найти</button>
            <a href="/courses">Сбросить</a>
        </form>

        <hr/>

        <!-- Результаты -->
        @if(page.getCourses().isEmpty())
            <p>Ничего не найдено</p>
        @else
            <p>Найдено: ${page.getCourses().size()}</p>
            @for(var course : page.getCourses())
                <div>
                    <h2><a href="/courses/${course.getId()}">${course.getName()}</a></h2>
                    <p>${course.getDescription()}</p>
                </div>
            @endfor
        @endif
    `
)