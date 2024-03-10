package br.upe.validation;

import br.upe.entities.Employee;
import br.upe.util.Facade;

import java.util.List;

public class ValidaFuncionario {
    public ValidaFuncionario() {
    }

    public static boolean isValido(String cpf, String senha) {
        if (!ValidaCpf.isCPF(cpf)) {
            return false;
        }

        if (senha.length() < 6) {
            return false;
        }

        Facade facade = new Facade();
        List<Employee> employees = facade.getAllEmployees();

        for (Employee employee : employees) {
            if (cpf.equals(employee.getCpf())) {
                if (senha.equals(employee.getSenha())) {
                    return true;
                }
            }
        }
        return false;
    }
}
