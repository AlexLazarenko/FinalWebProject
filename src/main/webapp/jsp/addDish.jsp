<%--
  Created by IntelliJ IDEA.
  User: AlexLazarenko
  Date: 02.02.2021
  Time: 22:59
  To change this template use File | Settings | File Templates.
--%>
<jsp:include page="header.jsp"/>

ADD DISH<br>
<form action="${pageContext.request.contextPath}/Home?action=addDishResult" method="post">
    Dish name:<br>
    <label>
        <input type="text" name="dishName" minlength="2" maxlength="25" title="Dish name" placeholder="Dish name"
               value=""
               required>
    </label> <br>
    Size:<br>
    <label>
        <input type="text" name="size" minlength="2" maxlength="25" title="Dish size" placeholder="Dish size" value=""
               required>
    </label> <br>
    Price:<br>
    <label>
        <input type="text" name="price" minlength="2" maxlength="25" title="Dish price" placeholder="Dish price"
               value=""
               required>
    </label> <br>
    Client info:<br>
    <label>
        <input type="text" name="clientInfo" minlength="2" maxlength="25" title="Client info" placeholder="Client info"
               value="" required>
    </label> <br>
    Staff info:<br>
    <label>
        <input type="text" name="staffInfo" minlength="2" maxlength="25" title="Staff info" placeholder="Staff info"
               value="" required>
    </label> <br>
    <div id="parentId">
        <div>
                Add ingredient:<br>
                <label>
                    <input type="text" name="name" minlength="2" maxlength="25" title="Ingredient name"
                           placeholder="Ingredient name" value="" required>
                    <input type="text" name="quantity" minlength="2" maxlength="25" title="Quantity"
                           placeholder="Quantity"
                           value="" required>
                </label>
                <a style="color:red;" onclick="return deleteField(this)" href="#">[-]</a>
                <a style="color:green;" onclick="return addField()" href="#">[+]</a>
        </div>
    </div>
    <br><br>
    <input type="submit" value="Submit">
</form>

<script>
    var countOfFields = 1; // Текущее число полей
    var curFieldNameId = 1; // Уникальное значение для атрибута name
    var maxFieldLimit = 15; // Максимальное число возможных полей
    function deleteField(a) {
        if (countOfFields > 1) {
            // Получаем доступ к ДИВу, содержащему поле
            var contDiv = a.parentNode;
            // Удаляем этот ДИВ из DOM-дерева
            contDiv.parentNode.removeChild(contDiv);
            // Уменьшаем значение текущего числа полей
            countOfFields--;
        }
        // Возвращаем false, чтобы не было перехода по сслыке
        return false;
    }

    function addField() {
        // Проверяем, не достигло ли число полей максимума
        if (countOfFields >= maxFieldLimit) {
            alert("Max field reached = " + maxFieldLimit);
            return false;
        }
        // Увеличиваем текущее значение числа полей
        countOfFields++;
        // Увеличиваем ID
        curFieldNameId++;
        // Создаем элемент ДИВ
        var div = document.createElement("div");
        // Добавляем HTML-контент с пом. свойства innerHTML
        div.innerHTML = "Add ingredient:<br><input name=\"name\" type=\"text\" minlength=\"2\" maxlength=\"25\" title=\"Ingredient name\" placeholder=\"Ingredient name\" value=\"\" required>\n" +
            "                <input type=\"text\" name=\"quantity\" minlength=\"2\" maxlength=\"25\" title=\"Quantity\" placeholder=\"Quantity\" value=\"\" required>" +
            "<a style=\"color:red;\" onclick=\"return deleteField(this)\" href=\"#\">[-]</a> " +
            " <a style=\"color:green;\" onclick=\"return addField()\" href=\"#\">[+]</a>";
        // Добавляем новый узел в конец списка полей
        document.getElementById("parentId").appendChild(div);
        // Возвращаем false, чтобы не было перехода по сслыке
        return false;
    }
</script>
<jsp:include page="footer.jsp"/>