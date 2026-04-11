@import org.example.hexlet.dto.users.BuildUserPage
@param BuildUserPage page

@template.layout.page(
    title = "Регистрация",
    content = @`
        <h1>Регистрация нового пользователя</h1>

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
        <form action="/users" method="post">
            <div style="margin-bottom: 15px;">
                <label>
                    Имя:
                    <br/>
                    <input type="text" name="name" value="${page.getName()}" style="width: 100%; padding: 5px;" />
                </label>
            </div>

            <div style="margin-bottom: 15px;">
                <label>
                    Email:
                    <br/>
                    <input type="email" name="email" value="${page.getEmail()}" style="width: 100%; padding: 5px;" />
                </label>
            </div>

            <div style="margin-bottom: 15px;">
                <label>
                    Пароль:
                    <br/>
                    <input type="password" name="password" style="width: 100%; padding: 5px;" />
                </label>
            </div>

            <div style="margin-bottom: 15px;">
                <label>
                    Подтверждение пароля:
                    <br/>
                    <input type="password" name="passwordConfirmation" style="width: 100%; padding: 5px;" />
                </label>
            </div>

            <button type="submit">Зарегистрировать</button>
            <a href="/users">Отмена</a>
        </form>
    `
)