@import org.example.hexlet.NamedRoutes
@import org.example.hexlet.model.User
@param User user

@template.layout.page(
    title = "Редактирование пользователя",
    content = @`
        <h1>Редактирование пользователя</h1>

        <form action="${NamedRoutes.userPath(user.getId())}" method="post">
            <input type="hidden" name="_method" value="patch" />

            <div>
                <label>Имя:<br/>
                    <input type="text" name="name" value="${user.getName()}" />
                </label>
            </div>
            <div>
                <label>Email:<br/>
                    <input type="email" name="email" value="${user.getEmail()}" />
                </label>
            </div>
            <div>
                <label>Пароль:<br/>
                    <input type="password" name="password" placeholder="Оставьте пустым, чтобы не менять" />
                </label>
            </div>

            <button type="submit">Сохранить</button>
            <a href="${NamedRoutes.usersPath()}">Отмена</a>
        </form>
    `
)