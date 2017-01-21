<%--
  Created by IntelliJ IDEA.
  User: Daniel
  Date: 1/11/2017
  Time: 2:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Hello JQuery</title>
     <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <link rel="stylesheet" href="/resources/demos/style.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript">
    $('#speed').selectmenu().bind('select',function(event){
        alert("hi there") ;
    });
    $('#files').selectmenu();
    $('#number').selectmenu();
</script>
</head>


<div class="demo">

    <form action="#">

        <fieldset>
            <label for="speed">Select a speed</label>
            <select name="speed" id="speed">
                <option>Slower</option>
                <option>Slow</option>
                <option selected="selected">Medium</option>
                <option>Fast</option>
                <option>Faster</option>
            </select>

            <label for="files">Select a file</label>
            <select name="files" id="files">
                <optgroup label="Scripts">
                    <option value="jquery">jQuery.js</option>
                    <option value="jqueryui">ui.jQuery.js</option>
                </optgroup>
                <optgroup label="Other files">
                    <option value="somefile">Some unknown file</option>
                    <option value="someotherfile">Some other file with a very long option text</option>
                </optgroup>
            </select>

            <label for="number">Select a number</label>
            <select name="number" id="number">
                <option>1</option>
                <option selected="selected">2</option>
                <option>3</option>
                <option>4</option>
                <option>5</option>
                <option>6</option>
                <option>7</option>
                <option>8</option>
                <option>9</option>
                <option>10</option>
                <option>11</option>
                <option>12</option>
                <option>13</option>
                <option>14</option>
                <option>15</option>
                <option>16</option>
                <option>17</option>
                <option>18</option>
                <option>19</option>
            </select>

            <label for="salutation">Select a title</label>
            <select name="salutation" id="salutation">
                <option disabled selected>Please pick one</option>
                <option>Mr.</option>
                <option>Mrs.</option>
                <option>Dr.</option>
                <option>Prof.</option>
                <option>Other</option>
            </select>
        </fieldset>

    </form>

</div>


</body>
</html>
