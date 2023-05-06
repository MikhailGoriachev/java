
    <section class="mx-5 my-4 bg-light shadow-sm border rounded-3 min-vh-100 p-3">

        <form method="post" action="/pages/task02/tables/appointments.php" class="w-50 mx-auto">
            <h4 class="text-center"><?= $isAdd ? "Добавление" : "Изменение" ?> приёма</h4>
            <input type="hidden" name="id" value="<?= $isAdd ? 0 : $_POST['id'] ?>">

            <div class="form-floating my-2">
                <select name="idDoctor" class="form-select">
                    <?= array_reduce($task->getDoctors(),
                        fn($p, $c) => $p . "<option value='{$c['id']}'" . ($c['id'] === $idDoctor ? 'selected' : '') . 
                                      ">{$c['id']}. {$c['doctor_surname']} {$c['doctor_name']} {$c['doctor_patronymic']} |
                                        {$c['speciality']}</option>") ?>
                </select>
                <label class="form-label">Доктор</label>
            </div>

            <div class="form-floating my-2">
                <select name="idPatient" class="form-select">
                    <?= array_reduce($task->getPatients(),
                        fn($p, $c) => $p . "<option value='{$c['id']}'" . ($c['id'] === $idPatient ? 'selected' : '') . 
                                      ">{$c['id']}. {$c['patient_surname']} {$c['patient_name']} {$c['patient_patronymic']}
                                        </option>") ?>
                </select>
                <label class="form-label">Пациент</label>
            </div>

            <div class="form-floating my-2">
                <input type="date" name="appointmentDate" class="form-control" placeholder="" value="<?= $date ?>"
                       required>
                <label class="form-label">Дата приёма</label>
            </div>

            <div class="col my-auto">
                <button class="btn btn-success w-8rem my-auto me-2" name="appointmentForm" value="<?= $isAdd ?>" type="submit"><?= $isAdd ? 'Добавить' : 'Сохранить' ?></button>
                <a class="btn btn-danger my-auto w-8rem"
                   href="/pages/task02/tables/appointments.php">Назад</a>
            </div>
        </form>
    </section>