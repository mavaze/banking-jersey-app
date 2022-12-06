package io.github.mavaze.corebank.resources;

import io.github.mavaze.centralbank.CentralQueueTemplate;
import io.github.mavaze.commons.domain.Bank;
import io.github.mavaze.corebank.services.BankOpsTemplate;
import io.github.mavaze.corebank.services.BankService;
import io.github.mavaze.corebank.services.TransactionService;
import io.github.mavaze.corebank.services.TxAccountService;

import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.Map;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("banks")
public class BankResource {

    @Inject
    private BankService bankService;

    @Inject
    private TxAccountService accountService;

    @Inject
    private TransactionService transactionService;

    @Inject
    // No intention of Injection here. It's just workaround to produce similar effect of @Bean in Spring
    private BankOpsTemplate template;

    @Inject
    // No intention of Injection here. It's just workaround to produce similar effect of @Bean in Spring
    // This bean creation should be part of central-bank
    private CentralQueueTemplate centralTemplate;

    /**
     * Registers a bank with Reserve/central/federal bank.
     * Not Implemented: A bank is functional when and till its license is valid.
     * @return Bank DTO
     */
    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Bank addBank(Map<String, String> properties) {
        final String code = properties.get("code");
        final String name = properties.get("name");
        return bankService.addByCodeAndName(code, name);
    }

    /**
     * Associate a branch to bank. A branch represent an unique BIC that will be
     * assigned to all customers added to the bank through this branch of bank.
     * @param bankCode
     * @return branchId and/or bic
     */
    @POST
    @Path("{bankCode}/branches")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Bank.Branch addBranch(@PathParam("bankCode") String bankCode, Map<String, String> properties) {
        final String bic = properties.get("bic");
        return bankService.addBranchToBank(bic, bankCode);
    }

    @Path("{bankCode}/accounts")
    public AccountResource getAccountResource() {
        return new AccountResource(accountService, transactionService);
    }
}
