package tn.cot.smartlighting.entities;

import jakarta.nosql.mapping.Column;
import jakarta.nosql.mapping.Entity;
import jakarta.nosql.mapping.Id;
import tn.cot.smartlighting.FieldPropertyVisibilityStrategy;

import javax.json.bind.annotation.JsonbVisibility;
import java.util.Objects;

@Entity
@JsonbVisibility(FieldPropertyVisibilityStrategy.class)
public class Assignment {
    @Id
    @Column
    String assignmentId;
    @Column
    String employeeId;
    @Column
    String lightingModuleId;
    @Column
    boolean repaired;
    @Column
    String repairedDate;

    public Assignment() {
    }

    public String getAssignmentId() {
        return assignmentId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getLightingModuleId() {
        return lightingModuleId;
    }

    public boolean isRepaired() {
        return repaired;
    }

    public String getRepairedDate() {
        return repairedDate;
    }

    public void setAssignmentId(String assignmentId) {
        this.assignmentId = assignmentId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public void setLightingModuleId(String lightingModuleId) {
        this.lightingModuleId = lightingModuleId;
    }

    public void setRepaired(boolean repaired) {
        this.repaired = repaired;
    }

    public void setRepairedDate(String repairedDate) {
        this.repairedDate = repairedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Assignment that = (Assignment) o;
        return repaired == that.repaired && Objects.equals(assignmentId, that.assignmentId) && Objects.equals(employeeId, that.employeeId) && Objects.equals(lightingModuleId, that.lightingModuleId) && Objects.equals(repairedDate, that.repairedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(assignmentId, employeeId, lightingModuleId, repaired, repairedDate);
    }

    @Override
    public String toString() {
        return "Assignment{" +
                "assignmentId='" + assignmentId + '\'' +
                ", employeeId='" + employeeId + '\'' +
                ", lightingModuleId='" + lightingModuleId + '\'' +
                ", repaired" + repaired +
                ", repairedDate=" + repairedDate +
                '}';
    }
    public static AssignmentBuilder builder() {
        return new AssignmentBuilder();
    }
    public static class AssignmentBuilder {
        private String assignmentId;
        private String employeeId;
        private String lightingModuleId;
        private boolean repaired;
        private String repairedDate;
        private AssignmentBuilder WithId(String id) {
            this.assignmentId = id;
            return this;
        }
        private AssignmentBuilder WithEmployeeId(String id) {
            this.employeeId = id;
            return this;
        }
        private AssignmentBuilder WithLightingModuleId(String id) {
            this.lightingModuleId = id;
            return this;
        }
        private AssignmentBuilder WithRepaired() {
            this.repaired = false;
            return this;
        }
        private AssignmentBuilder WithRepairedDate() {
            this.repairedDate = null;
            return this;
        }
        public Assignment build() {
            Assignment assignment = new Assignment();
            assignment.assignmentId = this.assignmentId;
            assignment.employeeId = this.employeeId;
            assignment.repaired = this.repaired;
            assignment.repairedDate = this.repairedDate;
            return assignment;
        }
    }
}
