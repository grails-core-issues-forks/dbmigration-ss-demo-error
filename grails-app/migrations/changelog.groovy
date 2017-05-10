databaseChangeLog = {

    changeSet(author: "sdelamo (generated)", id: "1494429203414-1") {
        createTable(tableName: "CFGUSU") {
            column(autoIncrement: "true", name: "ID", type: "BIGINT(19)") {
                constraints(primaryKey: "true", primaryKeyName: "CONSTRAINT_7")
            }

            column(name: "VERSION", type: "BIGINT(19)") {
                constraints(nullable: "false")
            }

            column(name: "S_USUARIO", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "SB_ACC_SERV_SOLIC", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "SB_NO_ACCTSERV", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "sdelamo (generated)", id: "1494429203414-2") {
        createTable(tableName: "ROLE") {
            column(autoIncrement: "true", name: "ID", type: "BIGINT(19)") {
                constraints(primaryKey: "true", primaryKeyName: "CONSTRAINT_2")
            }

            column(name: "VERSION", type: "BIGINT(19)") {
                constraints(nullable: "false")
            }

            column(name: "AUTHORITY", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "sdelamo (generated)", id: "1494429203414-3") {
        createTable(tableName: "USER") {
            column(autoIncrement: "true", name: "ID", type: "BIGINT(19)") {
                constraints(primaryKey: "true", primaryKeyName: "CONSTRAINT_27")
            }

            column(name: "VERSION", type: "BIGINT(19)") {
                constraints(nullable: "false")
            }

            column(name: "ACCOUNT_EXPIRED", type: "BOOLEAN(1)") {
                constraints(nullable: "false")
            }

            column(name: "ACCOUNT_LOCKED", type: "BOOLEAN(1)") {
                constraints(nullable: "false")
            }

            column(name: "ENABLED", type: "BOOLEAN(1)") {
                constraints(nullable: "false")
            }

            column(name: "password", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "PASSWORD_EXPIRED", type: "BOOLEAN(1)") {
                constraints(nullable: "false")
            }

            column(name: "USERNAME", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "sdelamo (generated)", id: "1494429203414-4") {
        createTable(tableName: "USER_ROLE") {
            column(name: "USER_ID", type: "BIGINT(19)") {
                constraints(nullable: "false")
            }

            column(name: "ROLE_ID", type: "BIGINT(19)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "sdelamo (generated)", id: "1494429203414-5") {
        addPrimaryKey(columnNames: "USER_ID, ROLE_ID", constraintName: "CONSTRAINT_B", tableName: "USER_ROLE")
    }

    changeSet(author: "sdelamo (generated)", id: "1494429203414-6") {
        addUniqueConstraint(columnNames: "AUTHORITY", constraintName: "UK_IRSAMGNERA6ANGM0PRQ1KEMT2", tableName: "ROLE")
    }

    changeSet(author: "sdelamo (generated)", id: "1494429203414-7") {
        addUniqueConstraint(columnNames: "USERNAME", constraintName: "UK_SB8BBOUER5WAK8VYIIY4PF2BX", tableName: "USER")
    }

    changeSet(author: "sdelamo (generated)", id: "1494429203414-8") {
        createIndex(indexName: "FKA68196081FVOVJHKEK5M97N3Y_INDEX_B", tableName: "USER_ROLE") {
            column(name: "ROLE_ID")
        }
    }

    changeSet(author: "sdelamo (generated)", id: "1494429203414-9") {
        addForeignKeyConstraint(baseColumnNames: "USER_ID", baseTableName: "USER_ROLE", constraintName: "FK859N2JVI8IVHUI0RL0ESWS6O", deferrable: "false", initiallyDeferred: "false", onDelete: "RESTRICT", onUpdate: "RESTRICT", referencedColumnNames: "ID", referencedTableName: "USER")
    }

    changeSet(author: "sdelamo (generated)", id: "1494429203414-10") {
        addForeignKeyConstraint(baseColumnNames: "ROLE_ID", baseTableName: "USER_ROLE", constraintName: "FKA68196081FVOVJHKEK5M97N3Y", deferrable: "false", initiallyDeferred: "false", onDelete: "RESTRICT", onUpdate: "RESTRICT", referencedColumnNames: "ID", referencedTableName: "ROLE")
    }
}
