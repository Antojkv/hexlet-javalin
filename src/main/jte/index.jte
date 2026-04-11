@import org.example.hexlet.NamedRoutes

@template.layout.page(
    title = "Главная",
    content = @`
        <h1>Добро пожаловать!</h1>
        <p>Это главная страница сайта.</p>
        <p>
            <a href="${NamedRoutes.coursesPath()}">К списку курсов</a> |
            <a href="${NamedRoutes.usersPath()}">К списку пользователей</a>
        </p>
    `
)