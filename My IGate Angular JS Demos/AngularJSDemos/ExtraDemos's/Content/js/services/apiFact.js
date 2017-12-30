/**
 * Created by colinlacy on 2/16/15.
 */
angular.module('factorLink')
.factory('apiFact', function() {
        return {
            searchObj: function() {
                return {
                    DebtorNumber: null,
                    DebtorNumberClient: null,
                    AdministrationNumber: null,
                    ClientNumber: null,
                    TypeOfIdNumber: null,
                    DebtorIdNumber: null,
                    DebtorName: null,
                    NodeType: null,
                    DebtorAddress: null,
                    DebtorZip: null,
                    DebtorCity: null,
                    DebtorRegion: null,
                    DebtorCountry: null
                };
            },
            connectObj: function() {
                return {
                    LoadDebtorData: true,
                    LoadAncestorData: true,
                    LoadChildData: true,
                    PageIndex: 0,
                    PageSize: 50,
                    CurrencyCode: "EUR"
                };
            }
        };
    });