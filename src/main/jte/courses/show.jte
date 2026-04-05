@import org.example.hexlet.dto.courses.CoursePage
@param CoursePage page

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${page.getCourse().getName()} - Хекслет</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            max-width: 1200px;
            margin: 0 auto;
            padding: 20px;
            background-color: #f5f5f5;
        }
        .container {
            background-color: white;
            border-radius: 8px;
            padding: 30px;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
        }
        h1 {
            color: #333;
            border-bottom: 3px solid #4CAF50;
            padding-bottom: 10px;
        }
        .course-info {
            margin: 20px 0;
        }
        .course-description {
            font-size: 18px;
            line-height: 1.6;
            color: #555;
            background-color: #f9f9f9;
            padding: 20px;
            border-radius: 8px;
            margin: 20px 0;
        }
        .course-id {
            color: #999;
            font-size: 14px;
            margin-top: 20px;
        }
        .back-link {
            display: inline-block;
            margin-top: 20px;
            color: #4CAF50;
            text-decoration: none;
            padding: 10px 20px;
            border: 1px solid #4CAF50;
            border-radius: 5px;
            transition: all 0.3s;
        }
        .back-link:hover {
            background-color: #4CAF50;
            color: white;
        }
        .not-found {
            text-align: center;
            color: #d32f2f;
            padding: 50px;
            font-size: 24px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>📖 ${page.getCourse().getName()}</h1>

        <div class="course-info">
            <div class="course-description">
                <strong>Описание курса:</strong><br>
                ${page.getCourse().getDescription()}
            </div>

            <div class="course-id">
                <strong>ID курса:</strong> ${page.getCourse().getId()}
            </div>
        </div>

        <a href="/courses" class="back-link">← Назад к списку курсов</a>
    </div>
</body>
</html>