@import org.example.hexlet.NamedRoutes
@import org.example.hexlet.dto.users.BuildUserPage
@param BuildUserPage page

@template.layout.page(
    title = "Регистрация",
    content = @`
        <h1>Регистрация нового пользователя</h1>

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

        <form action="${NamedRoutes.usersPath()}" method="post">
            <div>
                <label>Имя:<br/>
                    <input type="text" name="name" value="${page.getName()}" />
                </label>
            </div>
            <div>
                <label>Email:<br/>
                    <input type="email" name="email" value="${page.getEmail()}" />
                </label>
            </div>
            <div>
                <label>Пароль:<br/>
                    <input type="password" name="password" />
                </label>
            </div>
            <div>
                <label>Подтверждение пароля:<br/>
                    <input type="password" name="passwordConfirmation" />
                </label>
            </div>
            <button type="submit">Зарегистрировать</button>
            <a href="${NamedRoutes.usersPath()}">Отмена</a>
        </form>
    `
)