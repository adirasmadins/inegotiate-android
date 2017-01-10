package com.amazonaws.auth.policy.actions;

import com.amazonaws.auth.policy.Action;

public enum SQSActions implements Action {
    AllSqsActions("sqs:*"),
    AddPermission("sqs:AddPermission"),
    ChangeMessageVisibility("sqs:ChangeMessageVisibility"),
    CreateQueue("sqs:CreateQueue"),
    GetQueueUrl("sqs:GetQueueUrl"),
    DeleteMessage("sqs:DeleteMessage"),
    DeleteQueue("sqs:DeleteQueue"),
    GetQueueAttributes("sqs:GetQueueAttributes"),
    ListQueues("sqs:ListQueues"),
    ReceiveMessage("sqs:ReceiveMessage"),
    RemovePermission("sqs:RemovePermission"),
    SendMessage("sqs:SendMessage"),
    SetQueueAttributes("sqs:SetQueueAttributes"),
    SendMessageBatch("sqs:SendMessageBatch"),
    ChangeMessageVisibilityBatch("sqs:ChangeMessageVisibilityBatch"),
    DeleteMessageBatch("sqs:DeleteMessageBatch");
    
    private final String action;

    private SQSActions(String str) {
        this.action = str;
    }

    public String getActionName() {
        return this.action;
    }
}
